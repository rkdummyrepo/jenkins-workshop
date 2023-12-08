# jenkins-workshop

## Java Installation 
```
sudo apt-get update && sudo apt-get install openjdk-17-jdk -y 
```

## Jenkins Installations 

```
# Download Jenkins key
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key

# Add Jenkins repository to sources.list.d
echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] https://pkg.jenkins.io/debian-stable binary/" | sudo tee /etc/apt/sources.list.d/jenkins.list > /dev/null

# Update package list
sudo apt-get update

# Install Jenkins
sudo apt-get install jenkins -y

# get adminpassword
sudo cat /var/lib/jenkins/secrets/initialAdminPassword

```



