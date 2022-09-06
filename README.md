A little minecraft server info fetching api

Maven?
```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

	<dependency>
	    <groupId>com.github.BingulHan</groupId>
	    <artifactId>minecraftserverapi</artifactId>
	    <version>0.1.0</version>
	</dependency>
```

How to use?
```
MinecraftServerAPI serverAPI = new MinecraftServerAPI(); 
System.out.println(serverAPI.getData("mc.hypixel.net", InfoType.PORT)); // return 25565
System.out.println(serverAPI.getData("mc.hypixel.net", InfoType.ONLINE_SIZE)); // return online size 
System.out.println(serverAPI.getData("mc.hypixel.net", InfoType.ACTIVE)); // return online true 

//to send a new query you must create a new object. 
MinecraftServerAPI newApi = new MinecraftServerAPI(); 
System.out.println(newApi.getData("mc.bingulhan.xyz", InfoType.ACTIVE)); // return false
```
