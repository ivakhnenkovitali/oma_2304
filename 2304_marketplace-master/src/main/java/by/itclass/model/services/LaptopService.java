package by.itclass.model.services;

import by.itclass.model.dao.LaptopDao;
import by.itclass.model.dao.TvDao;
import by.itclass.model.entities.Laptop;
import by.itclass.model.entities.Tv;
import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static by.itclass.constants.JspConst.*;
import static by.itclass.constants.JspConst.PRICE_TO_PARAM;

public class LaptopService {
    private static LaptopService service;
    private LaptopDao dao;

    private LaptopService() {
        dao = LaptopDao.getInstance();
    }

    public static LaptopService getInstance() {
        if (Objects.isNull(service)) {
            service = new LaptopService();
        }
        return service;
    }

    public List<Laptop> getLaptops(Map<String, String[]> params) {
        var laptops = dao.selectAllLaptop();
        if (params.isEmpty()) {
            return laptops;
        }
        var vendors = params.get(VENDOR_PARAM);
        var cpus = params.get(CPU_PARAM);
        var memory = params.get(MEMORY_SIZE_PARAM);
        var from = params.get(PRICE_FROM_PARAM)[0];
        var to = params.get(PRICE_TO_PARAM)[0];
        return  laptops.stream()
                .filter(it -> vendors == null || ArrayUtils.contains(vendors, it.getVendor()))
                .filter(it -> cpus == null || ArrayUtils.contains(cpus, it.getCpu()))
                .filter(it -> memory == null || ArrayUtils.contains(memory, String.valueOf(it.getMemorySize())))
                .filter(it -> from.isEmpty() || it.getPrice() >= Double.parseDouble(from))
                .filter(it -> to.isEmpty() || it.getPrice() <= Double.parseDouble(to))
                .toList();
    }
}
