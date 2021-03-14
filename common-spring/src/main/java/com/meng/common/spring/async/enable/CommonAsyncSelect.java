package com.meng.common.spring.async.enable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ZuoHao
 * @date 2021/3/14
 */
public class CommonAsyncSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.meng.common.spring.starter.AsyncConfiguration"};
    }
}
