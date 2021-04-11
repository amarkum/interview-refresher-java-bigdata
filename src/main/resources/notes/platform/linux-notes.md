# Linux Command

What is Linux - It is an operating system which runs on major computers and other device today.

## Distributions ~
1. Debian, Ubuntu and Mint Distribution<br/>
 Supports `apt` for package installer

2. Red Hat, Fedora and CentOS<br/>
 Supports `yum` for package installer

## Debian, Ubuntu and Mint Distribution commands

### 1. Install SSH
`sudo apt install openssh-server`

Verify if `SSH` service is running <br/>
`sudo systemctl status ssh`

Ubuntu comes with a firewall configuration tool called UFW. <br/>
If the firewall is enabled on your system, make sure to open the SSH port:

`sudo ufw allow ssh`

### 2. Install Cloudera Manager

I. Download Install `.bin` from https://archive.cloudera.com/cm[X] <br/>
    `wget https://archive.cloudera.com/cm6/6.3.1/cloudera-manager-installer.bin`

II. Change `cloudera-manager-installer.bin` to have execute permissions <br/>
    `sudo chmod u+x cloudera-manager-installer.bin`
    
III. Run the Installer <br/>
     `sudo ./cloudera-manager-installer.bin`  
     
OR Download Cloudera VM <br/>
https://downloads.cloudera.com/demo_vm/virtualbox/cloudera-quickstart-vm-5.4.2-0-virtualbox.zip </br>

OR use a Docker <br/>
I. `docker pull cloudera/quickstart:latest` <br/>
II. `docker run --hostname=quickstart.cloudera --privileged=true -t -i -p 8888:8888 -p 80:80 cloudera/quickstart /usr/bin/docker-quickstart`     

### 3. Uninstall Cloudera Manager
`sudo sh /opt/cloudera/installer/uninstall-cloudera-manager.sh`   
     
### 4. Install canberra-gtk-module
`sudo apt install libcanberra-gtk-module libcanberra-gtk3-module`   

### 5. Install GKSU
You should use gksudo to launch graphical like gedit. To install it, simply type this command in terminal <br/>
`sudo apt-get install gksu`

### 6. SSH to root - Permission Denied
By default, the SSH server denies password-based login for root. 

`sudo gedit /etc/ssh/sshd_config` <br/>

```text
PermitRootLogin yes
#DenyUsers root
AllowUsers root OtherUser
```

Restart SSH Service
`sudo service ssh restart`

### 7. Failed to detect root privileges - Cloudera
`/etc/sudoers`

```text
cloudera ALL =(ALL) NOPASSWD: ALL
```

### 8. Too lookup space in particular directory by size
`sudo du -hs /tmp /home /home/amarkum/* | sort -rh | head -10`

## Red Hat, Fedora and CentOS

## Common Commands

### 1. Set `root` password
`sudo passwd root`

### 2. Disable `root` account
`sudo passwd -dl root`

## SSH
Generate the SSH Private and Public Keys
`ssh-keygen -t rsa -f ~/.ssh/amarkum -C amarkum`

## Put the public Key (amarkum.pub) to the instance where we want to login, and use the private key to connect.

## Login into Machine
`ssh -o StrictHostKeyChecking=no -i /Users/amarkumar/.ssh/amarkum amarkum@ip.or.hostname.com`

## Add a User in UNIX
useradd [Username]

## Delete a process usin a PORT
`$ sudo kill -9 $(sudo lsof -t -i:80)`

