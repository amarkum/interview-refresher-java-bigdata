# Microsoft Azure 

## Resource Group
We can have multiple services under one resource group. <br/>
Creation of Resource Group is must, as it track the cost and related service to it. <br/>

E.g A resource group can contain - storage account, databricks services etc.<br/>

## Services

## Storage Account
A storage account has containers, which holds the real data

## Databricks
A python styled notebook used to execute jobs, spark and others in a clustered environment.

# Mount Blob Storage to DataBricks
```python
dbutils.fs.mount(
	source = "wasbs://data@storageprofiling.blob.core.windows.net",
	mount_point = "/mnt/data",
	extra_configs = {"fs.azure.account.key.storageprofiling.blob.core.windows.net":"<KEY>"}
)
```



