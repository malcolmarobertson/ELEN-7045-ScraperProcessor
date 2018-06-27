package aps.domain.shared;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "aps-maps")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApsMaps  {



    @XmlElementWrapper(name = "standard-maps")
    @XmlElement(name = "standard-map")
    private List<StandardMap> standardMaps;

    public List<StandardMap> getStandardMaps() {
        return standardMaps;
    }

    public void setStandardMaps(List<StandardMap> standardMaps) {
        this.standardMaps = standardMaps;
    }

    @XmlElementWrapper(name = "municip-maps")
    @XmlElement(name = "municip-map")
    private List<StandardMap> municipMaps;

    public List<StandardMap> getMunicipMaps() {
        return municipMaps;
    }

    public void setMunicipMaps(List<StandardMap> municipMaps) {
        this.municipMaps = municipMaps;
    }



}
