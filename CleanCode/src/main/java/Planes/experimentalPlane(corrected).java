package Planes;

import models.ClassificationLevel;
import models.ExperimentalTypes;

public class experimentalPlane extends Plane{

    private ExperimentalTypes type;
    private ClassificationLevel levelClassify;

    public experimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationLevel levelClassify) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = levelClassify;
    }

    public ClassificationLevel getClassificationLevel(){
        return levelClassify;
    }

    public void setClassificationLevel(ClassificationLevel levelClassify){
        this.classificationLevel = levelClassify;
    }

    @Override
    public boolean equals(Object flyingParameters) {
        return super.equals(flyingParameters);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toDefineExperimentalPlane() {
        return "experimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
