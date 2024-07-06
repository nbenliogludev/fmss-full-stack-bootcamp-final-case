import AuthButton from "@/components/button/authButton";
import AuthInput from "@/components/input/authInput";

export default function RegisterPage() {
  return (
    <div className="flex min-h-screen items-center justify-center px-6 py-12 lg:px-8">
      <div className="sm:mx-auto sm:w-full sm:max-w-sm">
        <h2 className="mt-10 text-center text-2xl font-bold leading-9 tracking-tight text-gray-900">
          Sign up for an account
        </h2>
        <form action="#" method="POST" className="mt-10 space-y-6">
          <div>
            <label htmlFor="email" className="block text-sm font-medium leading-6 text-gray-900">
              Email address
            </label>
            <div className="mt-2">
              <AuthInput
                id="email"
                name="email"
                type="email"
                required={true}
                autoComplete="email"
              />
            </div>
          </div>

          <div>
            <label htmlFor="password" className="block text-sm font-medium leading-6 text-gray-900">
              Password
            </label>
            <div className="mt-2">
            <AuthInput
                id="password"
                name="password"
                type="password"
                required={true}
                autoComplete="current-password"
              />
            </div>
          </div>

          <div>
            <AuthButton type="submit" className="my-custom-class">
              Sign up
            </AuthButton>
          </div>
        </form>
      </div>
    </div>
  )
}
