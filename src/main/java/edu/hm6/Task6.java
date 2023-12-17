package edu.hm6;

import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Task6 {
    private Task6() {
    }

    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;
    private static final String PORT_MESSAGE_PREFIX = "Port ";

    private static final int EPMAP_PORT = 135;
    private static final int NETBIOS_NAME_SERVICE_PORT = 137;
    private static final int NETBIOS_DATAGRAM_SERVICE_PORT = 138;
    private static final int NETBIOS_SESSION_SERVICE_PORT = 139;
    private static final int MICROSOFT_DS_ACTIVE_DIRECTORY_PORT = 445;
    private static final int ADOBE_FLASH_PORT = 843;
    private static final int SSDP_PORT = 1900;
    private static final int DYNAMIC_WEB_SERVICES_DISCOVERY_PORT = 3702;
    private static final int MULTICAST_DNS_PORT = 5353;
    private static final int LLMNR_PORT = 5355;
    private static final int TEAMVIEWER_PORT = 5939;
    private static final int DISCORD_RPC_PORT = 6463;
    private static final int BITTORRENT_PORT = 6942;
    private static final int DROPBOX_LAN_SYNC_PROTOCOL_PORT = 17500;
    private static final int DROPBOX_LAN_SYNC_PROTOCOL_DB_LSP_PORT = 17600;
    private static final int MONGODB_PORT = 27017;
    private static final int ARCHISTEAMFARM_PORT = 42420;

    private static final Map<Integer, String> KNOWN_PORTS = new HashMap<>();

    static {
        KNOWN_PORTS.put(EPMAP_PORT, "EPMAP");
        KNOWN_PORTS.put(NETBIOS_NAME_SERVICE_PORT, "NetBIOS Name Service");
        KNOWN_PORTS.put(NETBIOS_DATAGRAM_SERVICE_PORT, "NetBIOS Datagram Service");
        KNOWN_PORTS.put(NETBIOS_SESSION_SERVICE_PORT, "NetBIOS Session Service");
        KNOWN_PORTS.put(MICROSOFT_DS_ACTIVE_DIRECTORY_PORT, "Microsoft-DS Active Directory");
        KNOWN_PORTS.put(ADOBE_FLASH_PORT, "Adobe Flash");
        KNOWN_PORTS.put(SSDP_PORT, "Simple Service Discovery Protocol (SSDP)");
        KNOWN_PORTS.put(DYNAMIC_WEB_SERVICES_DISCOVERY_PORT, "Dynamic Web Services Discovery");
        KNOWN_PORTS.put(MULTICAST_DNS_PORT, "Multicast DNS");
        KNOWN_PORTS.put(LLMNR_PORT, "LLMNR (Link-Local Multicast Name Resolution)");
        KNOWN_PORTS.put(TEAMVIEWER_PORT, "TeamViewer");
        KNOWN_PORTS.put(DISCORD_RPC_PORT, "Discord RPC");
        KNOWN_PORTS.put(BITTORRENT_PORT, "BitTorrent");
        KNOWN_PORTS.put(DROPBOX_LAN_SYNC_PROTOCOL_PORT, "Dropbox LAN Sync Protocol");
        KNOWN_PORTS.put(DROPBOX_LAN_SYNC_PROTOCOL_DB_LSP_PORT, "Dropbox LanSync Protocol (db-lsp)");
        KNOWN_PORTS.put(MONGODB_PORT, "MongoDB");
        KNOWN_PORTS.put(ARCHISTEAMFARM_PORT, "ArchiSteamFarm");
    }


    public static void scanPortsAndPrintResults() {
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            if (isPortAvailable(port)) {
                log.info(PORT_MESSAGE_PREFIX + port + " is available");
            } else {
                log.info(PORT_MESSAGE_PREFIX + port + " is not available");
                String serviceName = getServiceName(port);
                if (serviceName != null) {
                    log.info("  Service: " + serviceName);
                }
            }
        }
    }

    public static boolean isPortAvailable(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.close();
            return true;
        } catch (Exception e) {
            try {
                DatagramSocket datagramSocket = new DatagramSocket(port);
                datagramSocket.close();
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    private static String getServiceName(int port) {

        return KNOWN_PORTS.get(port);
    }
}
