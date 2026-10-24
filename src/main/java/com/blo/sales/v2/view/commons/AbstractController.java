package com.blo.sales.v2.view.commons;

import com.blo.sales.v2.view.components.inputPassword.InputPassword;
import com.blo.sales.v2.view.components.inputText.InputText;

public abstract class AbstractController {
    
    public String getTextFrom(InputText field) {
        return String.valueOf(field.getText().trim());
    }
    
    public String getTextFrom(InputPassword field) {
        return String.valueOf(field.getText().trim());
    }
    
}
