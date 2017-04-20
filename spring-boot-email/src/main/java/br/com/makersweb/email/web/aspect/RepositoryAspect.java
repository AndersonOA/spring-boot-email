/**
 * 
 */
package br.com.makersweb.email.web.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import br.com.makersweb.email.web.entity.DefaultEntity;

/**
 *
 * @author anderson.aristides
 *
 */
@Aspect
@Component
public class RepositoryAspect {

	@Around("execution(* br.com.makersweb.email.repository.*.save(..))")
	public Object doBasicDomainInformation(ProceedingJoinPoint pjp) throws Throwable {
		Object myEntity = pjp.getArgs()[0];
		if (myEntity instanceof DefaultEntity) {
			myEntity = setDefaultValues((DefaultEntity) myEntity);
		}

		Object retVal = pjp.proceed();
		return retVal;
	}

	private DefaultEntity setDefaultValues(DefaultEntity defaultDomain) {
		if (defaultDomain.getId() != null) {
			defaultDomain.setAtualizado(LocalDateTime.now());
			defaultDomain.setAtualizadoPor(this.getUser());
		} else {
			defaultDomain.setCriado(LocalDateTime.now());
			defaultDomain.setCriadoPor(this.getUser());
		}
		return defaultDomain;
	}

	private String getUser() {
		return "assinc";
	}

}
