# Docker Command

## I. Build a Docker Image

Latest Tag
`docker run -d -p 5000:5000 flask_webservice:latest`

Custom Tag
`docker build -f Dockerfile.prod -t react-app:prod .`<br/>

## II. Push the Docker Image

#### Re-tag docker image

Latest Tag
`docker tag flask_webservice amarxcode/flask_webservice`

Custom Tag
`docker tag sample:prod amarxcode/sample:prod`<br/>

#### Push the Image to Docker Hub
`docker push amarxcode/react-app:prod`

#### Docker Common Commands 
`docker image ls -a`

## III. Remove Docker Images & Container

#### To delete all containers including its volumes use,
`docker rm -vf $(docker ps -a -q)`

#### To delete all the images,
`docker rmi -f $(docker images -a -q)`

#### Kill all the running instance
`docker kill <hash>`

#### Remove the Docker Image
`docker system prune -a`



