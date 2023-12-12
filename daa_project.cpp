#include <iostream>
#include <utility>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;
int lis(int a[], int n)
{
    int i, j;
    int b[n];
    for (i = 0; i < n; i++)
        b[i] = 1;
    for (i = 1; i < n; i++)
    {
        for (j = 0; j < i; j++)
        {
            if (a[i] > a[j] && b[i] < b[j] + 1)
            {
                b[i] = b[j] + 1;
            }
        }
    }
    int max = 0;
    for (i = 0; i < n; i++)
    {
        if (b[i] > max)
            max = b[i];
    }
    return max;
}

int main()
{
    int i;
    int n;
    int index;
    cout<<"                 //*********BUILDING BRIDGES PROBLEM**********//"<<endl;
    cout << "Enter the total number of cities" << endl;
    cin >> n;
    int first_end[n];
    int other_end[n];
    map<int, int> mp;
    int reorder_first_end[n];
    cout << "Enter the co-ordinates of cities in north" << endl;
  
    for (i = 0; i < n; i++)
    {
        cin >> first_end[i];
        mp[first_end[i]] = i;
    }
    cout<<"<<-------co-ordinates on north bank of the river---------->>"<<endl;
    cout<<"<<----------------------------------------------------------->>"<<endl;
    cout<<"<<-------------------RIVER-------------------->>"<<endl;
    cout<<"<<----------------------------------------------------------->>"<<endl;
    cout<<"<<-------co-ordinates on south bank of the river---------->>"<<endl;
    cout << "Enter the co-ordinates of cities in south" << endl;
    for (i = 0; i < n; i++)  
    {
        cin >> other_end[i];
        index = mp[other_end[i]];
        reorder_first_end[index] = i + 1;
    }
    cout << "Maximum number of cities for which bridges can be made is " << endl;
    cout << lis(reorder_first_end, n);
    cout << endl;
    return 0;
}