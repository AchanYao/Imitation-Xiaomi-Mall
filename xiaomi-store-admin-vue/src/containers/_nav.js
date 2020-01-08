export default [
  {
    _name: 'CSidebarNav',
    _children: [
      {
        _name: 'CSidebarNavItem',
        name: 'Dashboard',
        to: '/dashboard',
        icon: 'cil-speedometer',
        badge: {
          color: 'primary',
          text: 'NEW'
        }
      },
      {
        _name: 'CSidebarNavTitle',
        _children: ['Theme']
      },
      {
        _name: 'CSidebarNavItem',
        name: 'Colors',
        to: '/theme/colors',
        icon: 'cil-drop'
      },
      {
        _name: 'CSidebarNavItem',
        name: 'Typography',
        to: '/theme/typography',
        icon: 'cil-pencil',
        disabled: true
      },
      // {
      //   _name: 'CSidebarNavTitle',
      //   _children: ['Components'],
      // },
      // {
      //   _name: 'CSidebarNavDropdown',
      //   name: 'Base',
      //   route: '/base',
      //   icon: 'cil-puzzle',
      //   items: [
      //     {
      //       name: 'Breadcrumbs',
      //       to: '/base/breadcrumbs',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Cards',
      //       to: '/base/cards',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Carousels',
      //       to: '/base/carousels',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     }, 
      //     {
      //       name: 'Collapses',
      //       to: '/base/collapses',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Forms',
      //       to: '/base/forms',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Jumbotrons',
      //       to: '/base/jumbotrons',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'List Groups',
      //       to: '/base/list-groups',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Navs',
      //       to: '/base/navs',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Navbars',
      //       to: '/base/navbars',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Paginations',
      //       to: '/base/paginations',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Popovers',
      //       to: '/base/popovers',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Progress Bars',
      //       to: '/base/progress-bars',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Switches',
      //       to: '/base/switches',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Tables',
      //       to: '/base/tables',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Tabs',
      //       to: '/base/tabs',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     },
      //     {
      //       name: 'Tooltips',
      //       to: '/base/tooltips',
      //       icon: 'cil-puzzle',
      //       disabled: true
      //     }
      //   ]
      // },
      // {
      //   _name: 'CSidebarNavDropdown',
      //   name: 'Buttons',
      //   route: '/buttons',
      //   icon: 'cil-cursor',
      //   items: [
      //     {
      //       name: 'Buttons',
      //       to: '/buttons/standard-buttons',
      //       icon: 'cil-cursor'
      //     },
      //     {
      //       name: 'Button Dropdowns',
      //       to: '/buttons/dropdowns',
      //       icon: 'cil-cursor'
      //     },
      //     {
      //       name: 'Button Groups',
      //       to: '/buttons/button-groups',
      //       icon: 'cil-cursor'
      //     },
      //     {
      //       name: 'Brand Buttons',
      //       to: '/buttons/brand-buttons',
      //       icon: 'cil-cursor'
      //     }
      //   ]
      // },
      // {
      //   _name: 'CSidebarNavItem',
      //   name: 'Charts',
      //   to: '/charts',
      //   icon: 'cil-chart-pie'
      // },
      // {
      //   _name: 'CSidebarNavDropdown',
      //   name: 'Icons',
      //   route: '/icons',
      //   icon: 'cil-star',
      //   items: [
      //     {
      //       name: 'CoreUI Icons',
      //       to: '/icons/coreui-icons',
      //       icon: 'cil-star',
      //       badge: {
      //         color: 'info',
      //         text: 'NEW'
      //       }
      //     },
      //     {
      //       name: 'Brands',
      //       to: '/icons/brands',
      //       icon: 'cil-star'
      //     },
      //     {
      //       name: 'Flags',
      //       to: '/icons/flags',
      //       icon: 'cil-star'
      //     }
      //   ]
      // },
      // {
      //   _name: 'CSidebarNavDropdown',
      //   name: 'Notifications',
      //   route: '/notifications',
      //   icon: 'cil-bell',
      //   items: [
      //     {
      //       name: 'Alerts',
      //       to: '/notifications/alerts',
      //       icon: 'cil-bell'
      //     },
      //     {
      //       name: 'Badges',
      //       to: '/notifications/badges',
      //       icon: 'cil-bell'
      //     },
      //     {
      //       name: 'Modals',
      //       to: '/notifications/modals',
      //       icon: 'cil-bell'
      //     }
      //   ]
      // },
      // {
      //   _name: 'CSidebarNavItem',
      //   name: 'Widgets',
      //   to: '/widgets',
      //   icon: 'cil-calculator',
      //   badge: {
      //     color: 'primary',
      //     text: 'NEW',
      //     shape: 'pill'
      //   }
      // },
      {
        _name: 'CSidebarNavDivider',
        _class: 'm-2'
      },
      {
        _name: 'CSidebarNavTitle',
        _children: ['Extras']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: 'Pages',
        route: '/pages',
        icon: 'cil-star',
        items: [
          {
            name: 'Login',
            to: '/pages/login',
            icon: 'cil-star'
          },
          {
            name: 'Register',
            to: '/pages/register',
            icon: 'cil-star'
          },
          {
            name: 'Error 404',
            to: '/pages/404',
            icon: 'cil-star'
          },
          {
            name: 'Error 500',
            to: '/pages/500',
            icon: 'cil-star'
          }
        ]
      },

      {
        _name: 'CSidebarNavDivider',
        _class: 'm-2'
      },
      {
        _name: 'CSidebarNavTitle',
        _children: ['管理']
      },
      {
        _name: 'CSidebarNavDropdown',
        name: '管理',
        route: '/pages',
        icon: 'cil-pencil',
        items: [
          {
            name: '商品',
            to: '/manager/items',
            icon: 'cil-star'
          },
          {
            name: '用户',
            to: '/users',
            icon: 'cil-star',
          },
        ]
      },
    ]
  }
]