package br.com.zup.casadocodigo.compartilhado;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


//Implementação copiada de: https://github.com/luizpcarvalho/orange-talents-01-template-casa-do-codigo/tree/main/src/main/java/br/com/zup/casadocodigo
@Documented
@Constraint(validatedBy = { })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
public @interface CPFouCNPJ {

    String message() default "Precisa ser um CPF ou CNPJ válido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
