package org.sapient.metalica.referencedataservice.util;

public interface CommonUtil {

    static boolean isEmpty(String obj) {
        return obj == null || obj.isEmpty();
    }

    static boolean notEmpty(String obj) {
        return !isEmpty(obj);
    }

}
