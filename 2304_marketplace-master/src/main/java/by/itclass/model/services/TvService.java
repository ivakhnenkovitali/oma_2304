package by.itclass.model.services;

import by.itclass.model.dao.TvDao;
import by.itclass.model.entities.Tv;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static by.itclass.constants.JspConst.*;

public class TvService {
    private static TvService service;
    private TvDao dao;

    private TvService() {
        dao = TvDao.getInstance();
    }

    public static TvService getInstance() {
        if (Objects.isNull(service)) {
            service = new TvService();
        }
        return service;
    }

    public List<Tv> getTvs(Map<String, String[]> params) {
        if (params.isEmpty()) {
            return dao.selectAllTv();
        }
        var vendors = params.get(VENDOR_PARAM);
        var screens = params.get(SCREEN_SIZE_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return dao.selectFilteredTv(vendors, screens, from, to);
    }
}
