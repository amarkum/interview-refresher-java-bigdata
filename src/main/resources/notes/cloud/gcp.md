
## Enable firewall Rules in GCP to specific IP.
`gcloud compute firewall-rules update vpc-gcp-one-fw-name --source-ranges $(curl ipecho.net/plain; echo)/32` <br/>

## GitLab Login to GCP Compute Engine
### SSH to Compute Engine Instance
`gcloud compute ssh --zone "us-east1-b" "app-webservice" --project "project-id"`

# Deploy App to Compute Engine
```yaml
gcp-deploy:
  stage: deploy
  image: google/cloud-sdk
  script:
    - gcloud config set project project-id
    - gcloud auth activate-service-account --key-file $GCP_SERVICE_CREDS
    - gcloud config set compute/zone us-central1-a
    - gcloud compute instances update-container instance-3 --container-image registry.gitlab.com/amarkum/app-webservice:latest
```
