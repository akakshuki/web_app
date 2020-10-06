package aem_trickcode.Model;

import lombok.Data;

@Data
public class FormTrickCode {
    private String category;
    private String knownCategoryValues;
    private String contextKey;

    /*
     * 
     * */
    public FormTrickCode(String category, String knownCategoryValues, String contextKey) {
        this.category = category;
        this.contextKey = contextKey;
        this.knownCategoryValues = knownCategoryValues;
    }
}
