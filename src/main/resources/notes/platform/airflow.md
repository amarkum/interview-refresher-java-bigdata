
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

#### Add a User and Password

`$ docker container ls`

Get the SHA for the airflow docker container and get in to the bash shell
`$ docker exec -it <SHA> bash`

### Make sure we have the required table

`$ python`

```python
from cryptography.fernet import Fernet
fernet_key= Fernet.generate_key()
print(fernet_key.decode())	
```
>> python_print_key

`$ export FERNET_KEY='python_print_key';` <br/>
`$ airflow initdb;`

create a User with `admin` as user and password as `admin` <br/>
`$ airflow create_user  --role Admin --username admin --email admin --firstname admin --lastname admin --password admin`

else open `python`

```python
exec('''
import airflow
from airflow import models, settings
from airflow.contrib.auth.backends.password_auth import PasswordUser
user = PasswordUser(models.User())
user.username = 'admin'
user.email = 'admin@example.com'
user.password = 'admin'
user.superuser = True
session = settings.Session()
session.add(user)
session.commit()
session.close()
exit()
''')
```
