package br.com.alunoonline.api.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = CursoValidator.class)
public @interface CursoValidation {

    String message() default "Curso não é válido, procure lista de cursos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
