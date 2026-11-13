package es.etg.daw.dawes.store.common.infraestructure.web.error;

import java.time.LocalDateTime;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.HtmlUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {


    //Aquí procesamos las excpciones de tipo NullPointer que se den en toda la aplicación de forma global.
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> nullPointerHandler(NullPointerException nfe) {
        String msg = nfe.getMessage();
		CustomResponse cr = new CustomResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, msg);

        String html = buildErrorHtml(cr);


		return ResponseEntity
                .status(cr.getStatus())
                .contentType(MediaType.TEXT_HTML) // Necesario para que el navegador sepa el formato de la respuesta (html)
                .body(html);
	}

    private String buildErrorHtml(CustomResponse cr) {
        return """
                <!DOCTYPE html>
                <html lang="es">
                <head>
                    <meta charset="UTF-8">
                    <title>Error interno en el servidor</title>
                </head>
                <body>
                    <div class="card">
                        <h1>Se ha producido un error</h1>
                        <dl>
                            <dt>Fecha</dt>   <dd>%s</dd>
                            <dt>Código</dt>  <dd>%s - %s</dd>
                            <dt>Mensaje</dt> <dd>%s</dd>
                        </dl>
                    </div>
                </body>
                </html>
                """.formatted(
                        escapeHtml(String.valueOf(cr.getDate())),
                        cr.getStatus().value(),
                        escapeHtml(cr.getStatus().getReasonPhrase()),
                        escapeHtml(cr.getMessage()));
    }

    private String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}