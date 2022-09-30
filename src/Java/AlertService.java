package Java;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class AlertService {
    private final MapAlertDAO storage = new MapAlertDAO();

    private AlertDAO obj;

    public AlertService(AlertDAO obj){
        this.obj=obj;
    }


    public UUID raiseAlert() {
        return this.obj.addAlert(new Date());
    }

    public Date getAlertTime(UUID id) {
        return this.obj.getAlert(id);
    }
}

interface AlertDAO{
    UUID addAlert(Date time);
    Date getAlert(UUID id);
}

class MapAlertDAO implements AlertDAO {
    private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();

    public UUID addAlert(Date time) {
        UUID id = UUID.randomUUID();
        this.alerts.put(id, time);
        return id;
    }

    public Date getAlert(UUID id) {
        return this.alerts.get(id);
    }
}
