package tech.viacomcbs.intothespring;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;

public class MagicAutoConfigurationImportSelector implements DeferredImportSelector {

    public MagicAutoConfigurationImportSelector() {
        System.out.println("MagicAutoConfigurationImportSelector created");
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("Importing auto configuration");
        return new String[]{};
    }
}
