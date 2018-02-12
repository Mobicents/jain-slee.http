package org.restcomm.slee.resource.http.heartbeat;

import java.io.IOException;
import java.util.Properties;

import javax.management.MBeanServer;
import javax.slee.resource.ResourceAdaptorContext;

public abstract interface HttpLoadBalancerHeartBeatingService {

	public static final String BALANCERS = "org.restcomm.resources.http-servlet-ra.BALANCERS";
	public static final String HEARTBEAT_INTERVAL = "org.restcomm.resources.http-servlet-ra.HEARTBEAT_INTERVAL";
	public static final String LB_HB_SERVICE_CLASS_NAME = "org.restcomm.resources.http-servlet-ra.LoadBalancerHeartBeatingServiceClassName";

	public abstract void init(ResourceAdaptorContext context,MBeanServer mBeanServer, String stackName, Properties paramProperties);

	public abstract void start();

	public abstract void stop();

	public abstract String[] getBalancers();

	public abstract boolean addBalancer(String balancerAddress, int rmiPort)
			throws IllegalArgumentException, NullPointerException, IOException;

	public abstract boolean addBalancer(String balancerAddress, int index, int rmiPort)
			throws IllegalArgumentException;

	public abstract HttpLoadBalancer[] getLoadBalancers();

	public abstract boolean removeBalancer(String balancerAddress, int rmiPort) throws IllegalArgumentException;

	public abstract boolean removeBalancer(String balancerAddress, int index, int rmiPort)
			throws IllegalArgumentException;

	public abstract void sendSwitchoverInstruction(HttpLoadBalancer paramLoadBalancer, String paramString1,
			String paramString2);

	public abstract long getHeartBeatInterval();

	public abstract void setHeartBeatInterval(long paramLong);

	public abstract void setJvmRoute(String paramString);

	public abstract String getJvmRoute();

	public abstract void addLoadBalancerHeartBeatingListener(
			HttpLoadBalancerHeartBeatingListener paramLoadBalancerHeartBeatingListener);

	public abstract void removeLoadBalancerHeartBeatingListener(
			HttpLoadBalancerHeartBeatingListener paramLoadBalancerHeartBeatingListener);

	public abstract void setGracefulShutdown(HttpLoadBalancer paramLoadBalancer, boolean paramBoolean);

	public abstract void setCustomInfo(HttpLoadBalancer paramLoadBalancer);

}
