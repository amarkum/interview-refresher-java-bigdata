# IP Address
IP Address is formed by the combination of 8-bit number separated by .<br/>
Each translates to 1 byte of data, translating it into 4 bytes of memory. <br/>

## Subnets and CIDR.
Subnet defines a range of IPs in a VPC, which is connected via a Router.<br/>
e.g. `192.68.0.0/21`<br/>
Number after back-slash is called CIDR, which specifies how many bits from the left has to be same in the IP Address Range.

## Find Public IP Address of the System
curl ipecho.net/plain ; echo

## Enable firewall Rules in GCP to specific IP
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-flask --source-ranges $(curl ipecho.net/plain; echo)/32`
`gcloud compute firewall-rules update vpc-gcp-one-fw-allow-react --source-ranges $(curl ipecho.net/plain; echo)/32`