package com.asps.graphqlcatalog.controller.graphql.exception;

import co.elastic.apm.api.ElasticApm;
import com.asps.graphqlcatalog.exception.CategoryNotFoundException;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class GraphQLExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(
            Throwable ex,
            DataFetchingEnvironment env) {

        if (ex instanceof CategoryNotFoundException) {

            return GraphqlErrorBuilder.newError(env)
                    .message("Category not found")
                    .errorType(ErrorType.NOT_FOUND)
                    .extensions(Map.of(
                            "code", "CATEGORY_NOT_FOUND"
                    ))
                    .build();
        }

        return null;
    }
}