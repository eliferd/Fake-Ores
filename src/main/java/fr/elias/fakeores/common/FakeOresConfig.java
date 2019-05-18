package fr.elias.fakeores.common;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

/* FAKE ORES OFFICIAL CONFIG CLASS
 * Implemented the new Forge config system. May be used later since Blocks/Items/Entities no longer uses ID.
 */

public class FakeOresConfig {

	public static final ForgeConfigSpec clientSpec;
	public static final Client client;
	
	public static final ForgeConfigSpec serverSpec;
	public static final Server server;
	
	static {
		Pair<Server, ForgeConfigSpec> serverPair = new ForgeConfigSpec.Builder().configure(Server::new);
		serverSpec = serverPair.getRight();
		server = serverPair.getLeft();
		
		Pair<Client, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(Client::new);
		clientSpec = clientPair.getRight();
		client = clientPair.getLeft();
	}
	
	public static class Server {
		
		public static ForgeConfigSpec.IntValue fakeores_prob;
		
		public Server (ForgeConfigSpec.Builder builder) {
			builder.comment("Global configuration").push("common");

			fakeores_prob = builder.comment("Sets the spawn probability. Higher the number is, lower the chances are.").defineInRange("fakeOresSpawnChances", 9, 0, Integer.MAX_VALUE);
			
			builder.pop();
		}
	}

	public static class Client {
		public Client (ForgeConfigSpec.Builder builder) {
			
		}
	}
	
}
