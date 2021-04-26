
## Enable firewall Rules inGCP to specific IP
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-flask --source-ranges $(curl ipecho.net/plain; echo)/32`
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-react --source-ranges $(curl ipecho.net/plain; echo)/32`

## GitLab Login to GCP Compute Engine
### SSH to the Compute Engine Instance
`gcloud compute ssh --zone "us-east1-b" "flask-webservice" --project "ecstatic-spirit-301116"`

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
