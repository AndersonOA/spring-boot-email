/**
 * 
 */
package br.com.makersweb.email.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.makersweb.email.web.entity.DefaultEntity;

/**
 *
 * @author anderson.aristides
 *
 */
@NoRepositoryBean
public interface IBaseRepository<T extends DefaultEntity> extends JpaRepository<T, Long> {

}
