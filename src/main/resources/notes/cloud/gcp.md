
## Enable firewall Rules inGCP to specific IP
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-flask --source-ranges $(curl ipecho.net/plain; echo)/32`
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-react --source-ranges $(curl ipecho.net/plain; echo)/32`

## GitLab Login to GCP Compute Engine
### SSH to the Compute Engine Instance
`gcloud compute ssh --zone "us-east1-b" "flask-webservice" --project "ecstatic-spirit-301116`

### Login to GitLab
`docker login registry.gitlab.com`

```text
WARNING! Your password will be stored unencrypted in /home/amarkumar/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store
```
