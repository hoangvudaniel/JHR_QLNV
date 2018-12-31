/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.GioiTinh;
import Model.NhanVien;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Menu {

    private QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
    private ArrayList<NhanVien> nhanViens = null;
    private ArrayList<NhanVien> dsTimKiem = null;

    public void menuFunction() {
        while (true) {
            System.out.println("Lua chon : ");
            System.out.println("1==> Nhap");
            System.out.println("2==> Hien");
            System.out.println("3==> Thu nhap cao nhat");
            System.out.println("4==> Thu nhap cao nhat theo gioi tinh");
            System.out.println("5==> Thu nhap cao nhat theo vi tri");
            System.out.println("6==> Thoat");
            int choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    nhanViens = quanLyNhanVien.nhapDanhSachNhanVien();
                    break;
                case 2:
                    quanLyNhanVien.hienDanhSachNhanVien(nhanViens);
                    break;
                case 3:
                    dsTimKiem = quanLyNhanVien.nhanVienThuNhapMax(nhanViens);
                    quanLyNhanVien.hienDanhSachNhanVien(dsTimKiem);
                    break;
                case 4:
                    System.out.println("0==>Nu || 1==>Nam || Khac==>Khong xac dinh");
                    int gt = new Scanner(System.in).nextInt();
                    switch (gt) {
                        case 0:
                            dsTimKiem = quanLyNhanVien.thuNhapMax_TheoGioiTinh(nhanViens, GioiTinh.NU);
                            break;
                        case 1:
                            dsTimKiem = quanLyNhanVien.thuNhapMax_TheoGioiTinh(nhanViens, GioiTinh.NAM);
                            break;
                        default:
                            dsTimKiem = quanLyNhanVien.thuNhapMax_TheoGioiTinh(nhanViens, GioiTinh.KHONG_XAC_DINH);
                            break;
                    }
                    quanLyNhanVien.hienDanhSachNhanVien(dsTimKiem);
                    break;
                case 5:
                    System.out.println("1==>Cong nhan || 2==>Nhan Vien Van Phong || Khac==>Quan Ly");
                    int viTri = new Scanner(System.in).nextInt();
                    dsTimKiem = quanLyNhanVien.thuNhapMax_TheoViTri(nhanViens, viTri);
                    quanLyNhanVien.hienDanhSachNhanVien(dsTimKiem);
                    break;
                case 6:
                    System.out.println("Thoat");
                    System.exit(0);
                default:
                    System.out.println("Ban chon sai. De nghi chon lai");
            }
        }

    }
}
