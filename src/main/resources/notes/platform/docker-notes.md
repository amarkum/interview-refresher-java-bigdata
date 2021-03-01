# Docker Command

## I. Build a Docker Image

Latest Tag
`docker build -t flask_webservice:latest .`<br/>

Custom Tag
`docker build -f Dockerfile.prod -t react-app:prod .`<br/>

## II. Push the Docker Image

#### Re-tag docker image

Latest Tag
`docker tag flask_webservice amarxcode/flask_webservice`<br/>

Custom Tag
`docker tag sample:prod amarxcode/sample:prod`<br/>

#### Push the Image to Docker Hub
Custom Tag
`docker push amarxcode/react-app:prod`<br/>

Latest Tag
`docker push amarxcode/flask_webservice`

### Pull the Dokcer Image & Run
`docker pull registry.gitlab.com/amarxcode/flask_webservice`<br/>
`docker run registry.gitlab.com/amarxcode/flask_webservice`<br/>

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


# Deploy App to Compute Engine
```yaml
gcp-deploy:
  stage: deploy
  image: google/cloud-sdk
  script:
    - gcloud config set project ecstatic-spirit-301116
    - gcloud auth activate-service-account --key-file $GCP_SERVICE_CREDS
    - gcloud config set compute/zone us-central1-a
    - gcloud compute instances update-container instance-3 --container-image registry.gitlab.com/amarkum/flask-api:latest
```