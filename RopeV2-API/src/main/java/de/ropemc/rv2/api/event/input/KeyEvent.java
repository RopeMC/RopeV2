package de.ropemc.rv2.api.event.input;

import de.ropemc.rv2.api.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class KeyEvent extends Event {
    @Getter
    private Key key;
    @Getter
    private Action action;
    private int modifiers;

    @AllArgsConstructor
    @Getter
    public enum Action {
        KEY_DOWN(1),
        KEY_HOLD(2),
        KEY_UP(0);
        private int code;
        public static Action get(int code){
            for(Action action : values()){
                if(action.getCode() == code){
                    return action;
                }
            }
            return null;
        }
    }

    @AllArgsConstructor
    @Getter
    public enum Key {
        D0(48),
        D1(49),
        D2(50),
        D3(51),
        D4(52),
        D5(53),
        D6(54),
        D7(55),
        D8(56),
        D9(57),
        A(65),
        B(66),
        C(67),
        D(68),
        E(69),
        F(70),
        G(71),
        H(72),
        I(73),
        J(74),
        K(75),
        L(76),
        M(77),
        N(78),
        O(79),
        P(80),
        Q(81),
        R(82),
        S(83),
        T(84),
        U(85),
        V(86),
        W(87),
        X(88),
        Y(89),
        Z(90),
        RSHIFT(344),
        ENTER(257),
        UP(265),
        DOWN(264),
        LEFT(263),
        RIGHT(262),
        ESCAPE(256);
        private int code;
        public static Key get(int code){
            for(Key key : values()){
                if(key.getCode() == code){
                    return key;
                }
            }
            return null;
        }
    }

}
