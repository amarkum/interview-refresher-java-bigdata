# System Design Notes

## Steps to follow to answer a system design Question

### 1. Clarify the Requirements as far as possible
- We must clarify all the possible requirement beforehand directly jumping out to answer.<br/>
Clarify and ask as many questions possible to get detail in-sight of the service we have been told to implement<br/>
E.g. Will it will require UI ? <br/>
what are the service that it should provide? who will be user of service? etc.

### 2. Scale Estimation
- We must also clarify what is the scale of the system. How we can upscale or downscale the system<br/>
What volume of disk space storage is required. What is the network bandwidth which is expected etc.

### 3. Define Abstract APIs
- We must provide an abstract API definition which will be to serve the request for the service<br/>
This also ensures that we have all the requirement met, and all the component of service is covered.

### 4. Data Modelling
- This involves how the components will interact with each other in the database<br/>
This ensures that we have all the components are covered, and we have derived the relationship

### 5. High Level Diagram
- We must with some graphics design a high level design of the system and its component<br/>
We can represent distinguished component of the system which will require to achieve a different task

### 6. Detailed Design
- We must elaborate few components in detail which are the major components<br/>
Also, we should talk about the pros and cons choosing the system, or the framework that we have considered.

### 7. Identify Bottleneck
- We must discuss on how can we make the system robust, so it's uptime is high and doest not fail<br/>
Also, we should consider majors that can help us to make the system fail-proof, e.g creating copies of the data etc.
