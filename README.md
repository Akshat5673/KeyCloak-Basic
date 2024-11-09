# KeyCloak-Basic

KeyCloak Should be installed before running this app. And all configurations related to DB should be done and updated in keycloak.conf file.

Run this command on terminal before running the application to run keycloak on localhost.
cmd in the keycloak folder then run "./bin/kc.sh start-dev" to start keycloak on the port assigned in keycloak.conf file.

On accessing keycloak on localhost, create your own realm and create a new admin user for logging in and delete the existing temporary admin.

To achieve role based authentication users should be created and assigned with the specific roles on the keycloak UI.
