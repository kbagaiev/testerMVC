package com.bagaiev.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.bagaiev.entities.IEntity;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author nedis
 * @version 1.0
 */
@MappedSuperclass
public abstract class AbstractEntity implements IEntity, Comparable<AbstractEntity> {
    private static final long serialVersionUID = 9161447837905426010L;

    @Transient
    public abstract Serializable getId();

    @Override
    public int hashCode () {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof AbstractEntity)) {
            return false;
        }
        AbstractEntity other = (AbstractEntity) obj;
        if (getId() == null) {
            if (other.getId() != null) {
                return false;
            }
        } else if (!getId().equals(other.getId())) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo (AbstractEntity o) {
        Object o1 = getId();
        Object o2 = o != null ? o.getId() : null;
        return new CompareToBuilder().append(o1, o2).toComparison();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
