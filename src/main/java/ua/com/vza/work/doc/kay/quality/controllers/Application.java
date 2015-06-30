package ua.com.vza.work.doc.kay.quality.controllers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kycenko on 25.05.15.
 */
@ApplicationPath("api")
class ApplicationConfig extends Application {
    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        c.add(ServiceController.class);
        classes = Collections.unmodifiableSet(c);
    }

    public Set<Class<?>> getClasses(){
        return classes;
    }
}
