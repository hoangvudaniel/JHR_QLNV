/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.CongNhan;
import Model.GioiTinh;
import Model.NhanVien;
import Model.NhanVienVanPhong;
import Model.QuanLy;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class QuanLyNhanVien {

    private static final int CONG_NHAN = 1;
    private static final int NHAN_VIEN_VAN_PHONG = 2;
    private static final int QUAN_LY = 3;
    private static ArrayList<NhanVien> listDSNV = new ArrayList<>();

    public ArrayList<NhanVien> nhapDanhSachNhanVien() {
        System.out.println("Chon : 1==>Cong nhan || 2==>Nhan Vien Van Phong || 3==>Quan Ly || Khac==>Thoat");
        int choice = new Scanner(System.in).nextInt();
        NhanVien nv = null;
        switch (choice) {
            case CONG_NHAN:
                nv = new CongNhan();
                nv.nhapNhanVien();
                listDSNV.add(nv);
                break;
            case NHAN_VIEN_VAN_PHONG:
                nv = new NhanVienVanPhong();
                nv.nhapNhanVien();
                listDSNV.add(nv);
                break;
            case QUAN_LY:
                nv = new QuanLy();
                nv.nhapNhanVien();
                listDSNV.add(nv);
                break;
            default:
                break;
        }
        return listDSNV;
    }

    public void hienDanhSachNhanVien(ArrayList<NhanVien> listDSNV) {
        listDSNV.forEach((nhanVien) -> {
            nhanVien.hienNhanVien();
        });

    }

    //nhan vien co thu nhap lon nhat cua cong ty
    public ArrayList<NhanVien> nhanVienThuNhapMax(ArrayList<NhanVien> listDSNV) {
        System.out.println("Danh sach nhan vien co thu nhap cao nhat cong ty :");
        double thuNhapMax = listDSNV.get(0).tinhThuNhap();
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() > thuNhapMax) {
                thuNhapMax = nhanVien.tinhThuNhap();
            }
        }
        ArrayList<NhanVien> listNV_ThuNhapMax = new ArrayList<>();
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() == thuNhapMax) {
                listNV_ThuNhapMax.add(nhanVien);
            }
        }
        return listNV_ThuNhapMax;
    }

    //thu nhap cao nhat theo gioi tinh
    public ArrayList<NhanVien> thuNhapMax_TheoGioiTinh(ArrayList<NhanVien> listDSNV, GioiTinh gioiTinh) {
        double thuNhapMax = listDSNV.get(0).tinhThuNhap();
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() > thuNhapMax && nhanVien.getGioiTinh() == gioiTinh) {
                thuNhapMax = nhanVien.tinhThuNhap();
            }
        }
        ArrayList<NhanVien> listNV_ThuNhapMax_TheoGioiTinh = new ArrayList<>();
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() == thuNhapMax && nhanVien.getGioiTinh() == gioiTinh) {
                listNV_ThuNhapMax_TheoGioiTinh.add(nhanVien);
            }
        }
        return listNV_ThuNhapMax_TheoGioiTinh;
    }

    //thu nhap theo vi tri
    private int layViTri(NhanVien nhanVien) {
        if (nhanVien instanceof CongNhan) {
            return CONG_NHAN;
        } else if (nhanVien instanceof NhanVienVanPhong) {
            return NHAN_VIEN_VAN_PHONG;
        } else {
            return QUAN_LY;
        }
    }

    public ArrayList<NhanVien> thuNhapMax_TheoViTri(ArrayList<NhanVien> listDSNV, int viTri) {

        double thuNhapMax = 0;
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() > thuNhapMax && layViTri(nhanVien) == viTri) {
                thuNhapMax = nhanVien.tinhThuNhap();
            }
        }
        ArrayList<NhanVien> listNV_ThuNhapMax_TheoViTri = new ArrayList<>();
        for (NhanVien nhanVien : listDSNV) {
            if (nhanVien.tinhThuNhap() == thuNhapMax && layViTri(nhanVien) == viTri) {
                listNV_ThuNhapMax_TheoViTri.add(nhanVien);
            }
        }
        return listNV_ThuNhapMax_TheoViTri;
    }
}
