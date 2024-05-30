package at.livekit.api.economy;

import org.bukkit.OfflinePlayer;

public interface IEconomyAdapter {
    
    public boolean hasEnough(OfflinePlayer player, double amount);

    public TransactionResult transfer(OfflinePlayer from, OfflinePlayer to, double amount);

    public double getBalance(OfflinePlayer player);

    public String getBalanceFormatted(OfflinePlayer player);

    public TransactionResult giveAmount(OfflinePlayer to, double amount);

    public TransactionResult withdrawAmount(OfflinePlayer from, double amount);

    public String getCurrencyString();
}
