package MonopolyLogicManager;

public class Banker {

    private int totalBalance;

    public Banker()
    {

    }

    public int getTotalBalance() {

        return this.totalBalance;
    }

    /**
     *
     * @param totalBalance
     */
    public void setTotalBalance(int totalBalance) {

        this.totalBalance = totalBalance;
    }

    /**
     *
     * @param owner
     * @param buyer
     */
    public void sellProperty(Planet property, Player owner, Player buyer) {
        // TODO - implement Banker.sellProperty
        //throw new UnsupportedOperationException();
        int newOwnerBalance = owner.getBalance() + property.getPrice();
        owner.setBalance(newOwnerBalance);

        int newBuyerBalance = buyer.getBalance() - property.getPrice();
        buyer.setBalance(newBuyerBalance);

        property.setOwner(buyer);

        owner.deleteTitleDeed(property);
        buyer.buyProperty(property);

    }

    /**
     *
     * @param player
     */
    public void declareBankrupt(Player player) {
        // TODO - implement Banker.declareBankrupt
        //throw new UnsupportedOperationException();
        if(player.getBalance() <= 0 && (!player.getTitleDeeds().isEmpty()))
        {
            player.setBankrupt();
        }
    }

    /**
     *
     * @param amount
     */
    public void changePlayerAccount(int amount) {
        // TODO - implement Banker.changePlayerAccount
        //throw new UnsupportedOperationException();

    }


    public void makeMortgage(Player player) {
        // TODO - implement Banker.makeMortgage
        //throw new UnsupportedOperationException();
        int newBalance;

        if(!player.getTitleDeeds().isEmpty())
        {

            newBalance = player.getBalance()
                    + player.getTitleDeeds().get(0).getMortgagePrice();

            player.setBalance(newBalance);

            player.deleteTitleDeed(player.getTitleDeeds().get(0));
        }


    }

}