/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public enum GioiTinh {
    NAM(1, "Nam"), NU(0, "Nu"), KHONG_XAC_DINH(-1, "Khong xac dinh");
    private int ma;
    private String ten;

    private GioiTinh() {
    }

    private GioiTinh(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

}
