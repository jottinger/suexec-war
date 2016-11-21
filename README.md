# suexec-war
A sample app to demonstrate EJB usage

# Description

This is a trivial Java EE 7 application to demonstrate EJB injection. It was originally created to explore injection possibilities in JSP, which wasn't working; the JSP file tries `@EJB` and `JNDI` injection; in the JSP, `JNDI` worked without a problem, but the `@EJB` annotation never fires.

As far as I can tell, this is by design.

I also created a servlet that used `@EJB` to inject the reference, which worked without a hitch. This forwards to a Handlebars template for rendering.

This application is useless and very very very simple; it was designed purely to test the injection points.
