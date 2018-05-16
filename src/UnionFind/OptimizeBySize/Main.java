package UnionFind.OptimizeBySize;

public class Main {

    // �Ա�UF1, UF2��UF3��ʱ������
    public static void main(String[] args) {

        // ʹ��10000�����ݹ�ģ
        int n = 10000;

        // ��ȻisConnectedֻ��ҪO(1)��ʱ��, ������union������ҪO(n)��ʱ��
        // ������Թ��̵��㷨���Ӷ���O(n^2)��
        UnionFindTestHelper.testUF1(n);

        // ����UF2��˵, ��ʱ��������O(n*h)��, hΪ���鼯������������߶�
        // �����ϸ�����, h��lognû�й�ϵ, ������ҿ��Լ���ô����
        // ���Ǻ������ݻ��h�����Ż�, �������, ���h��ԶС��n��
        // ��������ʵ�ֵ�UF2���Խ��ԶԶ����UF1, nԽ��Խ����:)
        UnionFindTestHelper.testUF2(n);

        // ����UF3��˵, ��ʱ��������Ȼ��O(n*h)��, hΪ���鼯������������߶�
        // ������UF3�ܸ��߸��ʵı�֤����ƽ��, �������ܸ���
        UnionFindTestHelper.testUF3(n);
    }
}
