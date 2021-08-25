package ioc;

import console.Menu;
import console.MenuItem;

public interface Context {

    MenuItem getShowTariffsMenuItem();

    MenuItem getShowUsersMenuItem();
    
    MenuItem getFilterTariffMenuItem();
    
    MenuItem getExitMenuItem();

    Menu getMenu();
}
