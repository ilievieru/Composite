package Visitor;

import base.GenericShape;

/**
 * Created by V3790149 on 5/4/2016.
 */
public interface Visitor {
    void serialize(GenericShape shape);
    void deserialize(GenericShape shape);
}
