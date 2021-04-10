
# Airflow Notes

## Enable Authentication in Airflow

### Map the volume as below in docker-compose.yml file

```yml
volumes:
  - ./dags:/usr/local/airflow/dags
  - ./config/airflow.cfg:/usr/local/airflow/airflow.cfg
```

Add the  `airflow.cfg` from from https://github.com/puckel/docker-airflow/blob/master/config/airflow.cfg

#### Make Below Changes to Enable authentication in Webserver

```yml
[webserver]
authenticate = True
auth_backend = airflow.contrib.auth.backends.password_auth

# Use FAB-based webserver with RBAC feature
rbac = True
```
