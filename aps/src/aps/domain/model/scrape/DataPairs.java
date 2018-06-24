package aps.domain.model.scrape;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class DataPairs {
    private List<DataPair> dataPairs;

    public List<DataPair> getDataPairs() {
        return dataPairs;
    }

    public void setDataPairs(List<DataPair> dataPairs) {
        this.dataPairs = dataPairs;
    }
}
