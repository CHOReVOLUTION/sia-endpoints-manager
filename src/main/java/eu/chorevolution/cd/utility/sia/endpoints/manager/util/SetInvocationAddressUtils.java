package eu.chorevolution.cd.utility.sia.endpoints.manager.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import eu.chorevolution.cd.utility.sia.endpoints.manager.business.model.ArtifactEndpointData;

public class SetInvocationAddressUtils {

	// <participant name , <role, ArtifactAddressData>>
	private static Map<String, Map<String, ArtifactEndpointData>> participantsArtifactsEndpointsData = new ConcurrentHashMap<>();
		
	public static void storeParticipantArtifactEndpointData(String participantName, String role, String name, List<String> endpoints){
		
		if(participantsArtifactsEndpointsData.containsKey(participantName)){
			participantsArtifactsEndpointsData.get(participantName).put(role, new ArtifactEndpointData(name, role, endpoints));
		}
		else{
			Map<String, ArtifactEndpointData> participantArtifactsEndpointsData = new ConcurrentHashMap<>();
			participantArtifactsEndpointsData.put(role, new ArtifactEndpointData(name, role, endpoints));
			participantsArtifactsEndpointsData.put(participantName, participantArtifactsEndpointsData);
		}
	}

	public static String getParticipantArtifactEndpointAddressFromRole(String participantName, String role){
		
		if(participantsArtifactsEndpointsData.containsKey(participantName) && participantsArtifactsEndpointsData.get(participantName).containsKey(role)){
			return participantsArtifactsEndpointsData.get(participantName).get(role).getEndpoints().get(0);
		}
		return null;
	}
	
}

