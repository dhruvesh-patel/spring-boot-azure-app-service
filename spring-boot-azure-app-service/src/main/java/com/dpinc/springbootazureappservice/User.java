package com.dpinc.springbootazureappservice;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class for USER model
 * @author Dhruvesh
 *
 */
@Entity(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor	
@Data
public class User {

	@Id
    private long id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "CREATED_BY", nullable = false)
    @CreatedBy
    private String createdBy;

    @Column(name = "UPDATED_BY", nullable = false)
    private String updatedBy;
        
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    private Date createdAt;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIMESTAMP", nullable = false)
    private Date updatedAt;
	
}


