package org.thegenealogyproject.api.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "thegenealogyproject.file-extensions-config")
@AllArgsConstructor
@Getter
public class FileExtensionsConfig {
    private List<String> allowedFileExtensions;
}
