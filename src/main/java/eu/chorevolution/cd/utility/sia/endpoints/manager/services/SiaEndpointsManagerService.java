package eu.chorevolution.cd.utility.sia.endpoints.manager.services;
		
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import eu.chorevolution.cd.utility.sia.endpoints.manager.baseservice.SetInvocationAddress;
import eu.chorevolution.cd.utility.sia.endpoints.manager.baseservice.SetInvocationAddressResponse;
import eu.chorevolution.cd.utility.sia.endpoints.manager.util.SetInvocationAddressUtils;
import eu.chorevolution.cd.utility.sia.endpoints.manager.util.Utils;
import java.net.URI;
import net.sf.saxon.dom.NodeWrapper;

public class SiaEndpointsManagerService {
	
	//private static Logger LOGGER = LoggerFactory.getLogger(SiaEndpointsManagerService.class);
	
	public static Document storeParticipantAddress(String participantFromName, NodeWrapper setInvocationAddressNodeWrapper){
		
		//LOGGER.info("CALLED storeParticipantAddress ON Sia Endpoints Manager");		
		SetInvocationAddress setInvocationAddress = (SetInvocationAddress) Utils.unmarshallNodeWrapperToObject(setInvocationAddressNodeWrapper, SetInvocationAddress.class);
		SetInvocationAddressUtils.storeParticipantArtifactEndpointData(participantFromName, setInvocationAddress.getArg0(), setInvocationAddress.getArg1(), setInvocationAddress.getArg2());
		return Utils.createDocumentFromObject(new SetInvocationAddressResponse());
	}
	
	
	public static String getParticipantAddress(String participantFromName, String participantToRoleName, String participantToAddress){
		
		//LOGGER.info("CALLED getParticipantAddress ON Sia Endpoints Manager");			
		String participantAddressRetrieved = SetInvocationAddressUtils.getParticipantArtifactEndpointAddressFromRole(participantFromName, participantToRoleName);
		//return participantAddressRetrieved != null ? participantAddressRetrieved:participantToAddress;
		if (participantAddressRetrieved != null) {
			if (!participantFromName.equals(participantToRoleName)) {
				//CD to CD
				if (participantAddressRetrieved.contains("/ode")) {
					String participantAddress_part1 = participantAddressRetrieved.substring(0, participantAddressRetrieved.lastIndexOf('/'));
					String participantAddress_part2 = participantToAddress.substring(participantToAddress.lastIndexOf('/'));
					return participantAddress_part1 + participantAddress_part2;	
				} else { //CD to provider e.g., personalweatherstations
					String participantAddress_part1 = participantAddressRetrieved.substring(0, participantAddressRetrieved.lastIndexOf('/'));
					String participantAddress_part2 = getPathUrl(participantToAddress);
					return participantAddress_part1 + participantAddress_part2;
				}
			} else { //CD to prosumer
				String participantFromNameWithoutSpace = participantFromName.replace(" ", "").toLowerCase();
				String participantAddress_part1 = participantAddressRetrieved.substring(0, participantAddressRetrieved.lastIndexOf('/'));
				//String participantAddress_part2 = participantToAddress.substring(participantToAddress.toLowerCase().indexOf(participantFromNameWithoutSpace));
				String participantAddress_part2 = getPathUrl(participantToAddress);
				return participantAddress_part1 + participantAddress_part2;
			}
		} else {
			return participantToAddress;
		}
	}	
	
	private static String getPathUrl(String participantToAddress) {
		try {
			URI uri = URI.create(participantToAddress);
			return uri.getPath();
		} catch (Exception e) {
			return "";
		}
	}
			
}
